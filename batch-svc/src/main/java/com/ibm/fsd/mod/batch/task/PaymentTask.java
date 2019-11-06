package com.ibm.fsd.mod.batch.task;

import com.ibm.fsd.mod.batch.model.Training;
import com.ibm.fsd.mod.batch.respository.StudentTrainingRepository;
import com.ibm.fsd.mod.batch.respository.TrainingRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
@Slf4j
public class PaymentTask {
    @Autowired
    private TrainingRepository trainingRepository;

    @Autowired
    private StudentTrainingRepository studentTrainingRepository;

    @Scheduled(cron = "00 14 17 * * *")
    @Transactional
    public void batchpoollist() {

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date todayDate = new Date();

        List<Training> payments = trainingRepository.findAllMentors();

        if (payments.size() > 0) {

            log.info(dateFormat.format(todayDate) + " start batch payment");

            payments.forEach(p -> {
                processpayment(todayDate, p.getStartDate(), p.getEndDate(), p.getFee(), p.getId());
            });

            log.info(dateFormat.format(todayDate) + " end batch payment");
        } else {
            log.info(dateFormat.format(todayDate) + " no payment batch task");
        }

    }

    private void processpayment(Date t_Date, Date s_Date, Date e_Date, BigDecimal fee, Long id) {
        final float THRESHOLD = 0.000001f;
        int day = (int) ((t_Date.getTime() - s_Date.getTime()) / (1000 * 60 * 60 * 24));
        int duration = (int) ((e_Date.getTime() - s_Date.getTime()) / (1000 * 60 * 60 * 24));

        float percent = duration / day;

        if (DateUtils.isSameDay(t_Date, e_Date)) {
            studentTrainingRepository.updatePayAmount(id, fee, "mod admin");
        }

        if (Math.abs(percent - 0.75f) > THRESHOLD) {
            studentTrainingRepository.updatePayAmount(id, fee.multiply(new BigDecimal(3)).divide(new BigDecimal(4)), "mod admin");
        } else if (Math.abs(percent - 0.5f) > THRESHOLD) {
            studentTrainingRepository.updatePayAmount(id, fee.divide(new BigDecimal(2)), "mod admin");
        } else if (Math.abs(percent - 0.25f) > THRESHOLD) {
            studentTrainingRepository.updatePayAmount(id, fee.divide(new BigDecimal(4)), "mod admin");
        }
    }

}
