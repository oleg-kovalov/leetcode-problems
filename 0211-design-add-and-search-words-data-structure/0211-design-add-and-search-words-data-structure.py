class TrieNode:
    def __init__(self):
        self.children = {}
        self.isEnd = False

class WordDictionary:

    def __init__(self):
        self.root = TrieNode()    

    def addWord(self, word: str) -> None:
        curr = self.root
        for c in word:
            if not c in curr.children:
                curr.children[c] = TrieNode()
            curr = curr.children[c]
        curr.isEnd = True

    def search(self, word: str) -> bool:
        currList = [self.root]
        for c in word:
            nextList = []
            for curr in currList:
                if c == '.':
                    nextList += [v for v in curr.children.values()]
                else:
                    if c in curr.children:
                        nextList.append(curr.children[c])
            currList = nextList

        for curr in currList:
            if curr.isEnd: return True

        return False


# Your WordDictionary object will be instantiated and called as such:
# obj = WordDictionary()
# obj.addWord(word)
# param_2 = obj.search(word)