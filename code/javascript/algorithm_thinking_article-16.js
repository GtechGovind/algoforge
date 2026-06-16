/**
 * Fancy traversal techniques for two-dimensional arrays
 */
export function solve(...args) {
  // Entry point for the course exercise: pass inputs directly.
  return reverse(...args);
}

var reverseWords = function(s) {
    let sb = "";
    for (let i = 0; i < s.length; i++) {
        let c = s.charAt(i);
        if (c !== ' ') {
            sb += c;
        } else if (sb !== "" && sb[sb.length - 1] !== ' ') {
            sb += ' ';
        }
    }
    if (sb[sb.length - 1] === ' ') {
        sb = sb.substring(0, sb.length - 1);
    }
    let chars = sb.split('');
    let n = chars.length;
    reverse(chars, 0, n - 1);
    for (let i = 0; i < n;) {
        for (let j = i; j < n; j++) {
            if (j + 1 === n || chars[j + 1] === ' ') {
                reverse(chars, i, j);
                i = j + 2;
                break;
            }
        }
    }
    return chars.join("");
};
function reverse(arr, i, j) {
    while (i < j) {
        let temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        i++;
        j--;
    }
}
