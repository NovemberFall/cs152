var net = require('net');
var eol = require('os').EOL;

var mySrver = net.createServer();
var clientList = [];

var listCmd = "\\list";
var renameCmd = "\\rename";
var privateCmd = "\\private";


myServer.on('connection', function(client) {
  client.name = client.remoteAddress + ':' + client.remotePort;
  client.write('Welcome, ' + client.name + eol);
  clientList.push(client);

  client.on('data', function(data) {
    process(data, client);
  });
});