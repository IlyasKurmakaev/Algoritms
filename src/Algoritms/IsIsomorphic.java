package Algoritms;

import java.util.*;

public class IsIsomorphic {

    public boolean isIsomorphic(String s, String t) { //"ab" "ca" fail, dont undastand rules
        List<UniqueCharacter> sWord = new ArrayList<>();

        UniqueCharacter uniqueCharacter = new UniqueCharacter(); //костыль
        Map<Character, UniqueCharacter> mapUniqueCharacters = new HashMap<>(); //костыль

        int length = s.length(); // длины двух строк одинаковы
        for (int i = 0; i < length; i++) { // создаём лист - слово, подробнее в комменте к class UniqueCharacter
            sWord.add(uniqueCharacter.getUniqueCharacter(mapUniqueCharacters, s.charAt(i)));
        }

        for (int i = 0; i < length; i++) {
            char tCharAtI = t.charAt(i);
            UniqueCharacter sLetter = sWord.get(i);

            if (!(sLetter.ch == tCharAtI)) {
                if (sLetter.alreadyChanged) {
                    return false;
                } else {
                    if (mapUniqueCharacters.containsKey(tCharAtI) && mapUniqueCharacters.get(tCharAtI).alreadyInUse) {
                        return false;
                    }
                    sLetter.alreadyChanged = true;
                    char tempCh = sLetter.ch; // ↓ замена ключа и значения
                    sLetter.ch = tCharAtI;
                    mapUniqueCharacters.put(tCharAtI, mapUniqueCharacters.get(sLetter.ch)); // заменя ключа и значения
                    mapUniqueCharacters.remove(tempCh);
                }
            } else {
                sLetter.alreadyChanged = true;
                sLetter.alreadyInUse = true;
            }
        }

        for (int i = 0; i < sWord.size(); i++) {
            if (sWord.get(i).ch != t.charAt(i)) {
                return false;
            }
        }
        return true;
    }


    private class UniqueCharacter { // смысл класса в создании букв в 1 экземпляре, дабы когда встречаются одни и те же буквы указывать на один и тот же экземпляр класса, соответственно изменяя всего 1 экземпляр мы меняем неограниченно большое количество букв
        private UniqueCharacter() {
        }

        public char ch;
        public boolean alreadyChanged = false; // если буква уже менялась
        public boolean alreadyInUse = false; // если буква повторяется

        private UniqueCharacter getUniqueCharacter(Map<Character, UniqueCharacter> mapUniqueCharacters, char chArg) {
            if (mapUniqueCharacters.containsKey(chArg)) {
                return mapUniqueCharacters.get(chArg);
            } else {
                UniqueCharacter newUniqueCharacter = new UniqueCharacter();
                newUniqueCharacter.ch = chArg;
                mapUniqueCharacters.put(chArg, newUniqueCharacter);
                return newUniqueCharacter;
            }
        }

        @Override
        public String toString() {
            return "UniqueCharacter{" +
                    "ch=" + ch +
                    ", alreadyChanged=" + alreadyChanged +
                    '}' + this.hashCode();
        }
    }
}
