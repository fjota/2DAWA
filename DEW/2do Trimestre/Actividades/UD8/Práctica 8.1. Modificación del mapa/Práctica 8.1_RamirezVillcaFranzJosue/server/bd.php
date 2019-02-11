<?php

header('Content-Type: text/txt; charset=utf-8');
$punto=json_decode(stripslashes($_REQUEST['punto']));
$ar=fopen("../maps/markers.json","r") or
  die("No se pudo abrir el archivo");
while (!feof($ar)) {
	$line=fgets($ar);
}
$line = substr($line, 0, strlen($line)-2);
$line .= $punto . ",];";

$ar=fopen("../maps/markers.json","w") or
  die("No se pudo abrir el archivo");
fputs($ar, $line);
  
?>