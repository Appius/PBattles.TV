#!/bin/bash
# config server
configsrv=/data/configdb
configsrv_log=/var/log/mongodb/mongod_configsrv.log
# router
router=/data/db
router_log=/var/log/mongodb/mongos.log
# shard 0-0
shard0=/srv/mongodb/rs0-0
shard0_log=/var/log/mongodb/rs0-0.log
# shard 0-1
shard1=/srv/mongodb/rs0-1
shard1_log=/var/log/mongodb/rs0-1.log
# shard 0-2
shard2=/srv/mongodb/rs0-2
shard2_log=/var/log/mongodb/rs0-2.log
# folder for logs
log_folder=/var/log/mongodb
# path for mongod process
mongod=/usr/bin/mongod
# path for mongos process
mongos=/usr/bin/mongos
# name of script file
prog=mongodb.sh
# code of exit
RETVAL=0
stop() {
	echo "Starting to stop everything..."
	#
	#stop config sever
	#
	grep_configsrv=`ps aux | grep -v grep | grep "${configsrv}"`
	if [ ${#grep_configsrv} -gt 0 ]
	then
	echo "Stop Config Server MongoDB."
	PID=`ps aux | grep -v grep | grep "${configsrv}" | awk '{ print $2 }'`
	sudo kill ${PID}
	else
	echo "Config Server MongoDB is not running."
	fi
	#
	# stop router
	#
	grep_router=`ps aux | grep -v grep | grep "mongos"`
	if [ ${#grep_router} -gt 0 ]
	then
	echo "Stop Router MongoDB."
	PID=`ps aux | grep -v grep | grep "mongos" | awk '{ print $2 }'`
	sudo kill ${PID}
	else
	echo "Router MongoDB is not running."
	fi
	#
	# stop shard 0-0
	#
	grep_shard0=`ps aux | grep -v grep | grep "${shard0}"`
	if [ ${#grep_shard0} -gt 0 ]
	then
	echo "Stop Shard0-0."
	PID=`ps aux | grep -v grep | grep "${shard0}" | awk '{ print $2 }'`
	sudo kill ${PID}
	else
	echo "Shard0-0 is not running."
	fi
	#
	# stop shard 0-1
	#
	grep_shard1=`ps aux | grep -v grep | grep "${shard1}"`
	if [ ${#grep_shard1} -gt 0 ]
	then
	echo "Stop Shard0-1."
	PID=`ps aux | grep -v grep | grep "${shard1}" | awk '{ print $2 }'`
	sudo kill ${PID}
	else
	echo "Shard0-1 is not running."
	fi
        #
        # stop shard 0-2
        #
	grep_shard2=`ps aux | grep -v grep | grep "${shard2}"`
	if [ ${#grep_shard2} -gt 0 ]
	then
	echo "Stop Shard0-2."
	PID=`ps aux | grep -v grep | grep "${shard2}" | awk '{ print $2 }'`
	sudo kill ${PID}
	else
	echo "Shard0-2 is not running."
	fi
	#
	# removing log files
	#
	echo "Deleting log files..."
	sudo rm -f "$configsrv_log"
	sudo rm -f "$router_log"
	sudo rm -f "$shard0_log"
	sudo rm -f "$shard1_log"
	sudo rm -f "$shard2_log"
        echo "All done."
	RETVAL=$?
}
start() {
	echo "Starting to run everything..."
	# create folder for log files if it isn't exist
	sudo mkdir -p ${log_folder}
	#
	# start config server
	#
	grep_configsrv=`ps aux | grep -v grep | grep "${configsrv}"`
	if [ -n "${grep_configsrv}" ]
	then
	echo "Config server MongoDB is already running."
	else
	echo "Start Config server MongoDB."
	sudo mkdir -p ${configsrv}
	sudo ${mongod} --port 27019 --configsvr --dbpath ${configsrv} --fork --logpath ${configsrv_log} --smallfiles
	fi
	#
	# start router
	#
	grep_router=`ps aux | grep -v grep | grep "mongos"`
	if [ -n "${grep_router}" ]
	then
	echo "Router MongoDB is already running."
	else
	echo "Start Router server MongoDB."
	sudo ${mongos} --port 27017 --configdb localhost:27019 --fork --logpath ${router_log}
	fi
	#
	# start shard 0-0
	#
	grep_shard0=`ps aux | grep -v grep | grep "${shard0}"`
	if [ -n "${grep_shard0}" ]
	then
	echo "Shard0-0 is already running."
	else
	echo "Start Shard0-0."
	sudo mkdir -p ${shard0}
	sudo ${mongod} --port 27020 --dbpath ${shard0} --replSet rs0 --fork --logpath ${shard0_log} --bind_ip 127.0.0.1 --smallfiles
	fi
	#
	# start shard 0-1
	#
	grep_shard1=`ps aux | grep -v grep | grep "${shard1}"`
	if [ -n "${grep_shard1}" ]
	then
	echo "Shard0-1 is already running."
	else
	echo "Start Shard0-1."
	sudo mkdir -p ${shard1}
	sudo ${mongod} --port 27021 --dbpath ${shard1} --replSet rs0 --fork --logpath ${shard1_log} --bind_ip 127.0.0.1 --smallfiles
	fi
	#
	# start shard 0-2
	#
	grep_shard2=`ps aux | grep -v grep | grep "${shard2}"`
	if [ -n "${grep_shard2}" ]
	then
	echo "Shard0-2 is already running."
	else
	echo "Start Shard0-2."
	sudo mkdir -p ${shard2}
	sudo ${mongod} --port 27022 --dbpath ${shard2} --replSet rs0 --fork --logpath ${shard2_log} --bind_ip 127.0.0.1 --smallfiles
	fi
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
	;;
    *)
	echo $"Usage: sh $prog {start|stop|restart}"
	exit 1
esac
exit $RETVAL
