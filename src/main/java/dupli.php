

<!DOCTYPE>
<html>
<title>
    <head> Fetch data from database</head>
</title>
<body>
<?php
include_once('index.php');
$query="select * from table2";
$result= mysql_query($query);

?>
<table>
    <tr>
        <th>Field name</th>
        <th>links</th>
    </tr>
</table>
</body>
</html>
