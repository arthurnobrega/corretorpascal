program questao2;
   var dia: integer;
       pagn: real;
       pagr: real;
   begin
     readln (dia, pagn);
   if (dia <= 31) and (dia >= 26)
    then
     begin 
      pagr:= pagn;
     end 
    else
     if (dia <= 25) and (dia >= 21)
      then
       begin
        pagr:= pagn * (1 - 0.02);
       end
      else      
       if (dia <= 20) and (dia >= 16) 
        then
         begin
          pagr:= pagn * (1 - 0.04);
         end
        else
         if (dia <= 15) and (dia >= 11)
          then
           begin
            pagr:= pagn * (1 - 0.06);
           end
          else
           if (dia <= 10) and (dia >= 6)
            then
             begin
              pagr:= pagn * (1 - 0.08);
             end
            else        
             if (dia <= 5) and (dia >= 1)
              then
               begin
                pagr:= pagn * (1 - 0.1);
               end
              else
               begin
               end;
   if (dia <= 31) and (dia >= 1)
    then
     begin
      writeln (pagr:5:2);
     end;
end.
