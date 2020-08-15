
// For encryption and decryption
var crypto = require('crypto');


    const encrypt =(text)=>{
        var algorithm = 'aes-256-ctr'; // or any other algorithm supported by OpenSSL
        var key = 'TheKey%%123%%qwerty';
    
        var cipher = crypto.createCipher(algorithm, key);  
        var encrypted = cipher.update(text, 'utf8', 'hex') + cipher.final('hex');
        console.log(encrypted);
        return encrypted;
    }


module.exports=encrypt;