<?php

try{
    $mypdo = new PDO("pgsql:host=localhost;dbname=testdb","postgres", "Moniajit@2003" );
    $sql = "SELECT * FROM table2";
    foreach ($mypdo->query($sql)as $row){
         print "</br>";
         print $row['key'].'-'.$row['links'].'</br>';
    }

}catch(PDOException $e){
    echo $e->getMessage();
}

?>

