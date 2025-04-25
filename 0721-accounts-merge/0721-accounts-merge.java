class Solution {
    HashMap<String, String> parentMap = new HashMap<>();

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> emailToName = new HashMap<>();

        DSU dsu = new DSU(accounts);
        for (List<String> account: accounts)
        {
            for (int i=1; i<account.size(); i++)
            {
                emailToName.putIfAbsent(account.get(i), account.get(0));
                for (int j=i+1; j<account.size(); j++)
                {
                    dsu.join(account.get(i), account.get(j));
                }
            }
        }

        Map<String, Set<String>> rootToChildren = new HashMap<>();
        for (Map.Entry<String, String> entry: parentMap.entrySet())
        {
            String child = entry.getKey();
            String parent = dsu.find(child);
            rootToChildren.putIfAbsent(parent, new TreeSet<>());
            rootToChildren.get(parent).add(child);
        }

        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, Set<String>> entry: rootToChildren.entrySet())
        {
            List<String> record = new ArrayList<>();
            String root = entry.getKey();
            record.add(emailToName.get(root));
            record.addAll(entry.getValue());
            
            result.add(record);
        }

        return result;


    }

    class DSU 
    {

        public DSU(List<List<String>> accounts)
        {
            for (List<String> account: accounts)
            {
                for (int i=1; i<account.size(); i++)
                {
                    parentMap.put(account.get(i), account.get(i));
                }
            }
        }

        public void join(String email1, String email2)
        {
            String parent1 = find(email1);
            String parent2 = find(email2);

            if (!parent1.equals(parent2))
            {
                parentMap.put(parent1, parent2);
            }
        }

        public String find(String current)
        {
            String root = parentMap.get(current);
            if (! root.equals(parentMap.get(root)))
            {
                root = find(root);
            }
            
            parentMap.put(current, root);
            return root;
        }

    }
}