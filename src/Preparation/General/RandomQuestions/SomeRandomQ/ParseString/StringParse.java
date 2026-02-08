package Preparation.General.RandomQuestions.SomeRandomQ.ParseString;

import java.util.ArrayList;
import java.util.List;

public class StringParse {
    /* Given an input String containing a sequence of values separated by commas (,), each value can be in one of the following formats:
    A sequence of characters without single quotes, double quotes, or commas (e.g. Hello).
    A value enclosed in single quotes ('). The content inside may include commas or double quotes. Remove the leading and trailing single quotes (e.g. 'Hi "TO" YOU' becomes Hi "TO" YOU).
    A value enclosed in double quotes ("). The content inside may include commas or single quotes. Remove the leading and trailing double quotes (e.g. "It's,a,cat" becomes It's,a,cat).
    Write code to parse the input string and return a list of the extracted values, with quotes removed as specified.
    Hello,World,Test
    'Hello,World',Test
    "Hello,World",Test
    'Hi "TO" YOU',Simple,Test
    "It's,a,cat"
    'Single,quote,"inside"',Double,"quote,'inside'"
    "Mixed,'quotes',and,commas",Normal
    'Embedded,comma,with "double"',Plain
    "Escaped,comma,with 'single'",'Another,one'
    'Just one value'
    "Just one value"
    SimpleValue
    '',""
    'A value, with, many, commas'
    "A value, with, many, commas"
    'Value with "double" and, comma',
    "Value with 'single' and, comma"
    'Leading and trailing spaces ', " Leading and trailing spaces "
    'Comma at end,'
    "Comma at end,"
    'Multiple,values',,,"Empty,fields"
    =>
    [Hello, World, Test]
    [Hello,World, Test]
    [Hello,World, Test]
    [Hi "TO" YOU, Simple, Test]
    [It's,a,cat]
    [Single,quote,"inside", Double, quote,'inside']
    [Mixed,'quotes',and,commas, Normal]
    [Embedded,comma,with "double", Plain]
    [Escaped,comma,with 'single', Another,one]
    [Just one value]
    [Just one value]
    [SimpleValue]
    [, ]
    [A value, with, many, commas]
    [A value, with, many, commas]
    [Value with "double" and, comma, Value with 'single' and, comma]
    [Leading and trailing spaces ,  Leading and trailing spaces ]
    [Comma at end,]
    [Comma at end,]
    [Multiple,values, , , Empty,fields]

    LeetCode 271: Encode and Decode Strings and
    LeetCode 1502: Parsing a CSV String

    */
    public static void main(String[] args) {

    }

    public List<String> method(String s) {
        List<String> result = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        boolean inSingle = false, inDouble = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '\'' && !inDouble) {
                inSingle = !inSingle;
                continue;
            }
            if (c == '"' && !inSingle) {
                inDouble = !inDouble;
                continue;
            }
            if (c == ',' && !inSingle && !inDouble) {
                result.add(current.toString());
                current.setLength(0);
            } else {
                current.append(c);
            }
        }
        result.add(current.toString());
        return result;
    }

}
