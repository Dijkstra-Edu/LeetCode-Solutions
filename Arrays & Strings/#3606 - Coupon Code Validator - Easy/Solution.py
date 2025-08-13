class Solution:
    def validCoupons(self, code, businessLine, isActive):
        valid_categories = {"electronics", "grocery", "pharmacy", "restaurant"}
        category_order = {
            "electronics": 0,
            "grocery": 1,
            "pharmacy": 2,
            "restaurant": 3
        }

        valid_list = []
        for c, b, active in zip(code, businessLine, isActive):
            if (active and
                b in valid_categories and
                len(c) > 0 and
                all(ch.isalnum() or ch == '_' for ch in c)):
                valid_list.append((b, c))

        valid_list.sort(key=lambda x: (category_order[x[0]], x[1]))
        return [c for _, c in valid_list]
