program camelo;

var
x, y, z, p1, p2, p3, soma: real;

begin
readln (x, y , z);
   If (x <= 3) then p1 := (5 * x);
   If (x >= 4) then p1:= (3 * x);
   If  (y <= 4) then p2 :=( 15 * y);
   If (y >= 5) then p2 :=(12 * y);
   If  (z <= 5) then p3 := (10 * z);
   If (z >= 6) then p3 := (8 * z);

soma:=(p1 + p2 + p3);
writeln (soma);
end.
