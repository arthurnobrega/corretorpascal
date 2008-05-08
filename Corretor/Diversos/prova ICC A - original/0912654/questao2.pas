program questao2;
var
   dp : integer;
   vp, total : real;

begin
   readln (vp);
   readln (dp);
   if dp <= 5
      then total := vp * 90 / 100
      else if dp <= 10
         then total := vp * 92 / 100
         else if dp <= 15
            then total := vp * 94 / 100
            else if dp <= 20
               then total := vp * 96 / 100
               else if dp <= 25
                  then total := vp * 98 / 100
                  else if dp <= 31
                     then total := vp * 1;
   writeln(total)
end.
