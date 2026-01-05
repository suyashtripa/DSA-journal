class Solution {
    public void reverseString(char[] s) {
        Stack<Character>stack = new Stack<>();
        for(int i=0;i<s.length;i++){
            stack.push(s[i]);

        }
        char[] res =new char[s.length-1];
        for(int i=0;i<s.length;i++){
            s[i] =stack.pop();
        }
    }
}











//         Stack<Character>stack = new Stack<>();
//         for(int i=0;i<s.length;i++){
//             stack.push(s[i]);
//         }
//         char[] result = new char[s.length-1];
//         for(int i =0;i<s.length;i++){
//             s[i] =stack.pop();
//         }
            
        
    
//     }
// }

















//         int left =0;
//         int right = s.length-1;
//         while(left < right){
//             char temp = s[left];
//             s[left] = s[right];
//             s[right] = temp;
//             left ++;
//             right--;

//         }
//     }
// }














//         int left = 0;
//         int right= s.length-1;
//         while(left < right){
//             char temp = s[left];
//             s[left] = s[right];
//             s[right] = temp;
//             left++;
//             right--;
//         }

//     }
// }

