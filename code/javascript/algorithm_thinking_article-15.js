/**
 * Shaobing sorting algorithm
 */
export function solve(...args) {
  // Entry point for the course exercise: pass inputs directly.
  return sort(...args);
}

var pancakeSort = function(cakes) {
    const res = [];
    sort(cakes, cakes.length);
    return res;
    function sort(cakes, n) {
        if (n == 1) return;
        let maxCake = 0;
        let maxCakeIndex = 0;
        for (let i = 0; i < n; i++) {
            if (cakes[i] > maxCake) {
                maxCakeIndex = i;
                maxCake = cakes[i];
            }
        }
        reverse(cakes, 0, maxCakeIndex);
        res.push(maxCakeIndex + 1);
        reverse(cakes, 0, n - 1);
        res.push(n);
        sort(cakes, n - 1);
    }
    function reverse(arr, i, j) {
        while (i < j) {
            let temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
};
