curl -X POST --user user:user -H "Accept:application/json" -H "Content-type:application/json" http://localhost:5000/todos?lang=uk -d'{"toDo": "ring","plannedDateTime": "2023-01-05T15:40:15.394Z","state": "PLANNED"}'
echo -e
curl -X POST --user user:user -H "Accept:application/json" -H "Content-type:application/json" http://localhost:5000/todos?lang=uk -d'{"toDo": "ring","plannedDateTime": "2023-02-05T15:40:15.394Z","state": "PLANNED"}'
echo -e
curl -X PUT --user user:user -H "Accept:application/json" -H "Content-type:application/json" http://localhost:5000/todos -d'{"toDo": "ring","plannedDateTime": "2023-02-05T15:40:15.394Z","state": "WORK_IN_PROGRESS"}'
echo -e
curl -X PUT --user user:user -H "Accept:application/json" -H "Content-type:application/json" http://localhost:5000/todos -d'{"toDo": "ring","plannedDateTime": "2023-02-05T15:40:15.394Z","state": "DONE"}'
echo -e
curl -X POST --user user:user -H "Accept:application/json" -H "Content-type:application/json" http://localhost:5000/todos?lang=uk -d'{"toDo": "string","plannedDateTime": "2023-02-05T15:40:15.394Z","state": "DONE"}'
echo -e
curl -X POST --user user:user -H "Accept:application/json" -H "Content-type:application/json" http://localhost:5000/todos -d'{"toDo": "string","plannedDateTime": "2023-02-05T15:40:15.394Z","state": "PLANNED"}'
echo -e
curl -X PUT --user user:user -H "Accept:application/json" -H "Content-type:application/json" http://localhost:5000/todos -d'{"toDo": "string","plannedDateTime": "2023-02-05T15:40:15.394Z","state": "CANCELED"}'
echo -e
curl -X PUT --user user:user -H "Accept:application/json" -H "Content-type:application/json" http://localhost:5000/todos?lang=uk -d'{"toDo": "string","plannedDateTime": "2023-02-05T15:40:15.394Z","state": "PLANNED"}'
echo -e
curl http://localhost:5000/todos
echo -e


curl http://localhost:5000/todos/ring
echo -e
curl -X DELETE --user user:user http://localhost:5000/todos/string
echo -e
curl -X DELETE --user admin:admin http://localhost:5000/todos/string?lang=uk
echo -e
curl  http://localhost:5000/todos
echo -e
