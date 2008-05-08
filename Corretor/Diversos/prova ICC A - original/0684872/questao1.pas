program Questao1;
var
  x,y,z: integer;
  total: real;
begin  
   readln (x);
     if x<=3
      then x:= x*5
         else;
           if x>= 6
             then x:= x*3;
   readln (y);
     if y<=4
       then y:= y*15
         else 
           if y>=5
             then y:= y*12;
    readln (z);
     if z<=5
       then z:= z*10
         else 
           if z>=6
             then z:= z*8;
    readln (total);
     total:= x+y+z;
end.  	
