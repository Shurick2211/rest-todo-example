curl -X POST --user user:user -H "Accept:application/json" -H "Content-type:application/json" http://mentorpracktic-env.eba-skm39mww.eu-central-1.elasticbeanstalk.com/todos?lang=uk -d'{"toDo": "ring","plannedDateTime": "2023-01-05T15:40:15.394Z","state": "PLANNED"}'
echo -e
curl -X POST --user user:user -H "Accept:application/json" -H "Content-type:application/json" http://mentorpracktic-env.eba-skm39mww.eu-central-1.elasticbeanstalk.com/todos?lang=uk -d'{"toDo": "ring","plannedDateTime": "2023-02-05T15:40:15.394Z","state": "PLANNED"}'
echo -e
curl -X PUT --user user:user -H "Accept:application/json" -H "Content-type:application/json" http://mentorpracktic-env.eba-skm39mww.eu-central-1.elasticbeanstalk.com/todos?lang=uk -d'{"toDo": "ring","plannedDateTime": "2023-02-05T15:40:15.394Z","state": "WORK_IN_PROGRESS"}'
echo -e
curl -X PUT --user user:user -H "Accept:application/json" -H "Content-type:application/json" http://mentorpracktic-env.eba-skm39mww.eu-central-1.elasticbeanstalk.com/todos -d'{"toDo": "ring","plannedDateTime": "2023-02-05T15:40:15.394Z","state": "DONE"}'
echo -e
curl -X POST --user user:user -H "Accept:application/json" -H "Content-type:application/json" http://mentorpracktic-env.eba-skm39mww.eu-central-1.elasticbeanstalk.com/todos?lang=uk -d'{"toDo": "string","plannedDateTime": "2023-02-05T15:40:15.394Z","state": "DONE"}'
echo -e
curl -X POST --user user:user -H "Accept:application/json" -H "Content-type:application/json" http://mentorpracktic-env.eba-skm39mww.eu-central-1.elasticbeanstalk.com/todos -d'{"toDo": "string","plannedDateTime": "2023-02-05T15:40:15.394Z","state": "PLANNED"}'
echo -e
curl -X PUT --user user:user -H "Accept:application/json" -H "Content-type:application/json" http://mentorpracktic-env.eba-skm39mww.eu-central-1.elasticbeanstalk.com/todos -d'{"toDo": "string","plannedDateTime": "2023-02-05T15:40:15.394Z","state": "CANCELED"}'
echo -e
curl -X PUT --user user:user -H "Accept:application/json" -H "Content-type:application/json" http://mentorpracktic-env.eba-skm39mww.eu-central-1.elasticbeanstalk.com/todos?lang=uk -d'{"toDo": "string","plannedDateTime": "2023-02-05T15:40:15.394Z","state": "PLANNED"}'
echo -e
curl http://mentorpracktic-env.eba-skm39mww.eu-central-1.elasticbeanstalk.com/todos
echo -e
curl http://mentorpracktic-env.eba-skm39mww.eu-central-1.elasticbeanstalk.com/todos/ring
echo -e
curl -X DELETE --user user:user http://mentorpracktic-env.eba-skm39mww.eu-central-1.elasticbeanstalk.com/todos/string
echo -e
curl -X DELETE --user admin:admin http://mentorpracktic-env.eba-skm39mww.eu-central-1.elasticbeanstalk.com/todos/string?lang=uk
echo -e
curl  http://mentorpracktic-env.eba-skm39mww.eu-central-1.elasticbeanstalk.com/todos
echo -e
