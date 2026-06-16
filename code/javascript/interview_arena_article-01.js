/**
 * Algorithm is like building Lego: hand-made LRU algorithm
 */
export function solve(...args) {
  // Entry point for the course exercise: pass inputs directly.
  return LRUCache(...args);
}

var LRUCache = function(capacity) {
    this.cap = capacity;
    this.cache = new Map();
};
LRUCache.prototype.get = function(key) {
    if (!this.cache.has(key)) {
        return -1;
    }
    this.makeRecently(key);
    return this.cache.get(key);
};
LRUCache.prototype.put = function(key, value) {
    if (this.cache.has(key)) {
        this.cache.set(key, value);
        this.makeRecently(key);
        return;
    }
    if (this.cache.size >= this.cap) {
        const oldestKey = this.cache.keys().next().value;
        this.cache.delete(oldestKey);
    }
    this.cache.set(key, value);
};
LRUCache.prototype.makeRecently = function(key) {
    const val = this.cache.get(key);
    this.cache.delete(key);
    this.cache.set(key, val);
};
