FROM node:10

WORKDIR /usr/src/app

COPY server/package*.json ./

RUN npm install

RUN npm install express

COPY server .

EXPOSE 80
CMD [ "node", "server.js" ]
