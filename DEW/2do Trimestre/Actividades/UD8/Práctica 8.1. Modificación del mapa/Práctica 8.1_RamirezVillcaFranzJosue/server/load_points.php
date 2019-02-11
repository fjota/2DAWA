<?php

header('Content-Type: text/txt; charset=utf-8');
//$punto=json_decode(stripslashes($_REQUEST['punto']));
$ar=fopen("../maps/markers.json","r") or
  die("No se pudo abrir el archivo");
  $line="";
while (!feof($ar)) {
	$line.=fgets($ar);
}
$line=str_replace("markers = ", "", $line);
$line=str_replace(",]","]", $line);
$line=str_replace(";","",$line);
echo $line;
?>