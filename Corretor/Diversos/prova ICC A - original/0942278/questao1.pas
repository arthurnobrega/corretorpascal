program questao;

var
x, y, z, p, q, r, t : integer;

begin
  readln(x ,y ,z);
    if (x <= 3)
            then p := 5*x
            else p := 3*x;
    if (y <= 4)
            then q := 15*y
            else q := 12*y;
    if (z <= 5)
            then r := 10*z
            else r := 8*z;
     t:= p + q + r ;
writeln (t);
end.
