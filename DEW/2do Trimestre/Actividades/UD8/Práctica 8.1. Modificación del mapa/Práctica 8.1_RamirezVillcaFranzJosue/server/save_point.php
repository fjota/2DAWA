<?php

header('Content-Type: text/txt; charset=utf-8');
//echo ">> " . $_REQUEST['point'] . "\n";
$punto=json_decode(stripslashes($_REQUEST['point']));
$ar=fopen("../maps/markers.json","r") or
  die("No se pudo abrir el archivo");
$line="";
while (!feof($ar)) {
	$line.=fgets($ar);
//	echo"LINE> " . $line. "\n";
}
$pos = strpos($line, "]");
$line = substr($line, 0, $pos);
$line .= json_encode($punto) . ",];";

$ar=fopen("../maps/markers.json","w") or
  die("No se pudo abrir el archivo");
fputs($ar, $line);

echo "hola";
  
?>