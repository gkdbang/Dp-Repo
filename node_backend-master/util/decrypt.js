
    // For encryption and decryption
    var crypto = require('crypto');

    const decrypt =(text)=>{
        var algorithm = 'aes-256-ctr'; // or any other algorithm supported by OpenSSL
        var key = 'TheKey%%123%%qwerty';
    
        var decipher = crypto.createDecipher(algorithm, key);
        var decrypted = decipher.update(text, 'hex', 'utf8') + decipher.final('utf8');
        console.log(decrypted);
        return decrypted;
    }

    module.exports=decrypt;