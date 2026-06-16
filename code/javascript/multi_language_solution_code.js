/**
 * solution_code
 */
export function solve(...args) {
  // Entry point for the course exercise: pass inputs directly.
  return isAdditiveNumber(...args);
}

var isAdditiveNumber = function(num) {
    let n = num.length;
    for (let i = 1; i <= n; i++) {
        for (let j = i + 1; j <= n; j++) {
            let first = num.substring(0, i);
            let second = num.substring(i, j);
            if (isValid(num, first, second)) {
                return true;
            }
        }
    }
    return false;
}
var isValid = function(num, first, second) {
    if ((first.startsWith("0") && first.length > 1)
            || (second.startsWith("0") && second.length > 1)) {
        return false;
    }
    let sumStr = strAdd(first, second);
    let next = num.substring(first.length + second.length);
    if (!next.startsWith(sumStr)) {
        return false;
    }
    if (next === sumStr) {
        return true;
    }
    return isValid(num.substring(first.length), second, sumStr);
}
var strAdd = function(a, b) {
    let n = a.length, m = b.length;
    let i = n - 1, j = m - 1, add = 0;
    let builder = [];
    while (i >= 0 || j >= 0 || add != 0) {
        let x = i >= 0 ? a.charAt(i) - '0' : 0;
        let y = j >= 0 ? b.charAt(j) - '0' : 0;
        let result = x + y + add;
        builder.push(result % 10);
        add = Math.floor(result / 10);
        i--;
        j--;
    }
    return builder.reverse().join('');
}
