#!/bin/bash
# path for server.js
path=/home/azureuser/Apps/signalmaster/server.js
# name of script file
prog=signalmaster.sh
# code of exit
RETVAL=0
stop() {
	echo "Start to stopping signalmaster..."
	sudo forever stop ${path}
	echo "All done."
	RETVAL=$?
start() {
	echo "Starting signalmaster..."
	sudo forever start ${path}
	echo "All done."
	RETVAL=$?
}
case $1 in
    start )
	start
	;;
    stop )
	stop
	;;
    restart )
	stop
	start
	echo "Restarting is done."
	;;
    *)
	echo $"Usage: sh $prog {start|stop|restart}"
	exit 1
esac
exit $RETVAL