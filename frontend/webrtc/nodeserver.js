var static = require('node-static');
var http = require('http');
var file = new(static.Server)();
var app = http.createServer(function (req, res) {
  file.serve(req, res);
}).listen(2013);

var io = require('socket.io').listen(app);

io.sockets.on('connection', function (socket){

	socket.on('message', function (message) {
		io.sockets.in(socket.room).emit('message', message);
	});

	socket.on('join', function (room) {
		var num_clients = io.sockets.clients(room).length;
		socket.join(room);
        socket.room = room;
        socket.emit('message', 'you have joined the room '+ room + '. it has ' + num_clients + ' users online');
	});

});

