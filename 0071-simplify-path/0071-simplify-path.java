class Solution {
    public String simplifyPath(String path) {
        String[] s = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String component : s) {
            if (component.isEmpty() || component.equals(".")) {
                continue;
            }
            if (component.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(component);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String component : stack) {
            sb.append("/").append(component);
        }

        return sb.length() > 0 ? sb.toString() : "/";
    }
}