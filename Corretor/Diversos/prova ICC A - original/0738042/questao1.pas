program questao1;
   var g, ca, ci : integer;
       pg, pca, pci, total: real;
     begin
      readln (g, ca, ci);
    if (g < 0)
     then
      begin  
      end
     else 
      if (g > 3)
       then
        begin
         pg:= g * 3;
        end
       else
        begin
         pg:= g * 5;
        end;
    if (ca < 0)    
     then
      begin
      end
     else
      if (ca > 4)
       then
        begin
         pca:= ca * 12;
        end
       else
        begin
         pca:= ca * 15;
        end;
    if (ci < 0)
     then
      begin
      end
     else
      if (ci > 5)
       then
        begin
         pci:= ci * 8;
        end
       else
        begin
         pci:= ci * 10;
        end;
  if (g >= 0) and (ca >= 0) and (ci >= 0)
   then
    begin
     total:= pg + pca + pci;
     writeln (total:5:2);
    end;
end.


