'use strict';
var mysql = require('mysql');
var connection = mysql.createConnection({
    host: 'localhost',
    user: 'root',
    password: 'cuatroie',
    database: 'healthypork'
});
connection.connect();

/**
 * Eliminado de datos de luminosidad.
 * Eliminado un dato de luminosidad en la base de datos.
 *
 * idLuminosity Integer Id del dato de luminosidad
 * returns String
 **/
module.exports.deleteLuminosity = function (req, res, next) {
    //Parameters
    console.log("Mostramos peticion", req);
    var query = "DELETE FROM Luminosity WHERE id = " + req.idLuminosity.originalValue
    connection.query(query, function (error, results, fields) {
        if (error) throw error;
        console.log('The solution is: ', results);
        res.send({
            message: results
        });
    });
};


/**
 * Devuelve todos los datos relacionados con la luminosidad.
 * Devuelve todos los datos relacionados con la luminosidad.
 *
 * date String Fecha de la recogida de la información
 * returns String
 **/
module.exports.getLuminosity = function (req, res, next) {
    //Parameters
    console.log(req.date.originalValue);
    var query = "SELECT * FROM Luminosity WHERE date = '" + req.date.originalValue + "'"
    connection.query(query, function (error, results, fields) {
        if (error) throw error;
        console.log('The solution is: ', results);
        res.send({
            message: results
        });
    });
};


/**
 * Registra un nuevo dato de luminosidad.
 * Creacion de nuevos datos asociados a la luminosidad.
 *
 * luminosity Luminosity 
 * returns String
 **/
module.exports.postLuminosity = function (req, res, next) {
    //Parameters
    console.log(req.undefined.originalValue.amount);
    var query = 'INSERT INTO Luminosity SET ?'
    var date = new Date();
    var data = {
        amount: req.undefined.originalValue.amount,
        date: date
    }
    connection.query(query, [data], function (error, results, fields) {
        if (error) throw error;
        console.log('The solution is: ', results);
        res.send({
            message: results
        });
    });
};


/**
 * Modifica un dato de luminosidad previamente registrado
 * Modifica un dato de luminosidad previamente registrado
 *
 * luminosity Luminosity 
 * returns String
 **/
module.exports.putLuminosity = function (req, res, next) {
    //Parameters
    console.log(req);
    var query = 'UPDATE Luminosity SET ? WHERE id = ' + req.undefined.originalValue.idLuminosity
    var date = new Date();
    var data = {
        amount: req.undefined.originalValue.amount,
        date: date
    }
    connection.query(query, [data], function (error, results, fields) {
        if (error) throw error;
        console.log('The solution is: ', results);
        res.send({
            message: results
        });
    });
};




