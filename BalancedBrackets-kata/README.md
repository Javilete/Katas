BALANCED BRACKETS

A bracket is considered to be any one of the following characters: (, ), {, }, [, or ].

A matching pair of brackets is not balanced if the set of brackets it encloses are not matched. For example, {[(])} is not balanced because the contents in between { and } are not balanced. The pair of square brackets encloses a single, unbalanced opening bracket, (, and the pair of parentheses encloses a single, unbalanced closing square bracket, ].

Sample Input
3
{[()]}
{[(])}
{{[[(())]]}}

Sample Output
YES
NO
YES