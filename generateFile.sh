
file='numbers.txt'
if [ -f $file ]; then  
   rm $file
fi 

for i in `seq 1 10000`
do
  printf "%d\n" "$i"  >> $file
done
