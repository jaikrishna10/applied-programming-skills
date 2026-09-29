#include <vector>
#include <unordered_map>
#include <stack>

class Solution {
public:
    std::vector<int> nextGreaterElement(std::vector<int>& nums1, std::vector<int>& nums2) {
        std::unordered_map<int, int> next_greater;
        std::stack<int> st;

        for (int num : nums2) {
            while (!st.empty() && st.top() < num) {
                next_greater[st.top()] = num;
                st.pop();
            }
            st.push(num);
        }

        // For remaining elements in the stack, there is no next greater element
        while (!st.empty()) {
            next_greater[st.top()] = -1;
            st.pop();
        }

        std::vector<int> ans;
        ans.reserve(nums1.size());
        for (int num : nums1) {
            ans.push_back(next_greater[num]);
        }

        return ans;
    }
};