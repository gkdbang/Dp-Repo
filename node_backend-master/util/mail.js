
// For mail
var nodemailer = require('nodemailer');
const decrypt=require('./decrypt');

//let text='3cce97db0d36e77422b68920ca14d89e';
//let pass=decrypt(text);
//console.log(pass);

const sendEmail=(to,password)=>{
    console.log("=======Send Mail========= "+ to);
    var transporter = nodemailer.createTransport({
        host: "smtp.office365.com", // hostname
        secureConnection: true, // TLS requires secureConnection to be false
        port: 587, // port for secure SMTP
        tls: {
           ciphers:'SSLv3'
        },
        auth: {
            user: 'qcampus@quinnox.com',
            pass: 'qUINn0x@32!'
        }
    });

    // setup e-mail data, even with unicode symbols
    var mailOptions = {
        from: 'qcampus@quinnox.com', // sender address (who sends)
        to: to, // list of receivers (who receives)
        subject: 'Your Credentials', // Subject line
        text: 'This is your Password for login => '+password, // plaintext body
        //html: '<b>Hello world </b><br> This is the first email sent with Nodemailer in Node.js' // html body
    };

    // send mail with defined transport object
    transporter.sendMail(mailOptions, function(error, info){
        if(error){
            return console.log(error);
        }
        else{
            console.log("Email sent successfully");
            //console.log('Message sent: ' + info.response);
        }      
    });

}

module.exports=sendEmail;