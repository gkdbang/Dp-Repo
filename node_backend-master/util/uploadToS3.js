const fs = require('fs');
const AWS = require('aws-sdk');
//const S3 = require('s3');

const BUCKET = 'campus-images'
const REGION = 'ap-south-1'
const ACCESS_KEY = 'AKIAYNUP2JMTBKDKPQRF'
const SECRET_KEY = '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'

// AWS.config.update({

// })

const s3 = new AWS.S3({
    accessKeyId: ACCESS_KEY,
    secretAccessKey: SECRET_KEY,
    region: REGION
});

const uploadFileToS3 = (file,fileName) => {

    return new Promise((resolve, reject)=>{
            //console.log(JSON.stringify(file.data));

        var base64data = new Buffer(file.data).toString('base64');

        // Setting up S3 upload parameters
        const params = {
            Bucket: BUCKET,
            Body: base64data,
            Key: new Date().getTime() +"_"+ fileName  // File name you want to save as in S3
        };

        // Uploading files to the bucket
        s3.upload(params, function(err, data) {
            if (err) {
                reject(err)
            }
            console.log(`File uploaded successfully. ${data.Location}`);
            let path=data.Location;
            resolve(path)
        });        
})


};

module.exports=uploadFileToS3;
