morseList = [".- ", "-... ", "-.-. ", "-.. ", ". ", "..-. ", "--. ", ".... ", ".. ", ".--- ", "-.- ", ".-.. ", "-- ", "-. ", "--- ", ".--. ", "--.- ", ".-. ", "... ", "- ", "..- ", "...- ", ".-- ", "-..- ", "-.-- ","--.. "]
englishList = ["a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l","m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x","y", "z"]
cypherText = input("Enter your text or cypher:"); #morse should have 1 space btw letters and 3 btw words.
output = "";
if "-" in cypherText or "." in cypherText: 
  words = cypherText.split("   ");
  for word in words:
    for letter in word.split(" "):
      for i in range(0,26):
        if letter.strip() == morseList[i].strip(): output += englishList[i];
    output += " "
else:
  for j in range(0,26):
    cypherText = cypherText.replace(englishList[j], morseList[j])
  output = cypherText
print (output)