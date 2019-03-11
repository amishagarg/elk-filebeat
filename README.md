# elk-filebeat

This Springboot App gives the user an option to browse for the log file, upload it. That log file is read by Filebeat, 
which is sent to Logstash. Logstash processes it, then dumps it to elasticsearch. From there, we can visualize it in Kibana.

How to run it:
The app automatically triggers the batchfiles necessary to start the ELKF stack as soon as you press the submit button in localhost:8080

The directories for the batch files are:
Master Batch file
D:\cdbatch.bat\

BatchFileF.bat in
D:\F\

BatchFileL.bat in
D:\L\bin

Where F is for filebeat and L is for logstash.
