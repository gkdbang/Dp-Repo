//const http = require('http');
const express = require('express');
const route = require('./routes/route');
const bodyParser = require('body-parser');
//const multer = require('multer');
const fileUpload = require('express-fileupload');
//const upload = multer();
var cors = require('cors')

// f = require('util').format,
// fs = require('fs');

// //Specify the Amazon DocumentDB cert
// var ca = [fs.readFileSync("rds-combined-ca-bundle.pem")];

// console.log(ca);
const app = express();

const mongoose = require('mongoose');
//var MongoClient = require('mongodb').MongoClient
mongoose.connect('mongodb://13.232.15.51:27017/CampusAutomation', { useNewUrlParser: true, useUnifiedTopology: true,useFindAndModify: false })
// MongoClient.connect('mongodb://CampusAdmin:CampusAdmin123@docdb-2020-02-11-09-16-44.cluster-c02g21ntou2i.ap-south-1.docdb.amazonaws.com:27017/CampusAutomation?authSource=admin', 
// { 
//   sslValidate: true,
//   sslCA:ca,
//   useNewUrlParser: true
// })
  .then(() => {
    console.log('Connected to db server successfully.');
  })
  .catch((error) => {
    console.log('DB server connection failed.', error);
  });

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));
//app.use(upload.array()); 

// enable files upload
app.use(fileUpload({
  createParentPath: true
}));

app.use(cors());

app.use('/campusAutomation', route);



let port = 8080;
app.listen(port, () => {
  console.log('Server is up and running on port numner ' + port);
});










