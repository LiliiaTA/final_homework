string[] array1 = new string[6] {"hello", "world", "-2", ":-)", "yes", "done"};
string[] array2 = new string[array1.Length];
void newArray(string[] array1, string[] array2)
{
    int count = 0;
    for (int i = 0; i < array1.Length; i++)
    {
    if(array1[i].Length <= 3)
        {
        array2[count] = array1[i];
        count++;
        }
    }
}

void printArray(string[] array)
{
    for (int i = 0; i < array.Length; i++)
    {
        Console.Write($"{array[i]} ");
    }
    Console.WriteLine();
}

newArray(array1, array2);
Console.WriteLine($"Массив из строк, длина которых меньше либо равна 3 символам: ");
printArray(array2);