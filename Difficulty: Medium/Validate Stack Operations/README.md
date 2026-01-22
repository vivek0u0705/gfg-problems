<h2><a href="https://www.geeksforgeeks.org/problems/stack-permutations/1">Validate Stack Operations</a></h2><h3>Difficulty Level : Difficulty: Medium</h3><hr><div class="problems_problem_content__Xm_eO"><p data-start="212" data-end="288"><span style="font-size: 14pt;">You have an empty stack and can perform push and pop operations in it.&nbsp;<br>You are given two arrays <strong data-start="237" data-end="244">a[]</strong> and <strong data-start="249" data-end="256">b[] </strong>of unique elements and&nbsp;both having the same length.</span></p>
<ul data-start="290" data-end="458">
<li data-start="290" data-end="365"><span style="font-size: 14pt;"> </span>
<p data-start="292" data-end="365"><span style="font-size: 14pt;"><strong data-start="292" data-end="299">a[]</strong> represents the order in which elements are pushed into a stack.</span></p>
<span style="font-size: 14pt;"> </span></li>
<li data-start="366" data-end="458"><span style="font-size: 14pt;"> </span>
<p data-start="368" data-end="458"><span style="font-size: 14pt;"><strong data-start="368" data-end="375">b[]</strong> represents the order in which elements are expected to be popped from the stack.</span></p>
<span style="font-size: 14pt;"> </span></li>
</ul>
<p><span style="font-size: 14pt;"> </span></p>
<p data-start="460" data-end="611"><span style="font-size: 14pt;">Determine whether the given push and pop sequences are <strong>valid</strong>.</span></p>
<p data-start="460" data-end="611"><span style="font-size: 14pt;"><strong>Note:</strong> The stack is empty initially and must also be empty after performing all the operations.</span></p>
<p><span style="font-size: 14pt;"><strong>Examples:</strong></span></p>
<pre><span style="font-size: 14pt;"><strong>Input: </strong>a[] = [1, 2, 3], b[] = [2, 1, 3]
<strong>Output: </strong>true
<strong>Explanation:<br></strong>Take 1 from a and push it into the stack,
Take 2 from a and push it into the stack,
Take 2 from b and pop it from the stack,<br>Take 1 from b and pop it from the stack,
Take 3 from a and push it into the stack,
Take 3 from b and pop it from the stack<br>So, all the push and pop sequences are valid.</span></pre>
<pre><span style="font-size: 14pt;"><strong>Input: </strong>a[] = [1, 2, 3], b[] = [3, 1, 2]
<strong>Output: </strong>false
<strong>Explanation: </strong>After pushing 1, 2, and 3, we can pop 3 as required. But the next element in b[] is 1, while the stack top is 2. Since 1 is blocked under 2, this order cannot be achieved.<br></span></pre>
<p><span style="font-size: 14pt;"><strong>Constraints:</strong><br>1&nbsp;<span style="background-color: #ffffff; color: #1e2229; font-family: Nunito;">≤ </span><span style="font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;">a.size()=b.size() </span><span style="background-color: #ffffff; color: #1e2229; font-family: Nunito;">≤</span><span style="font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;">&nbsp;10</span><sup style="font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;">5<br></sup>0&nbsp;<span style="background-color: #ffffff; color: #1e2229; font-family: Nunito;">≤</span> a[i], b[i] <span style="background-color: #ffffff; color: #1e2229; font-family: Nunito;">≤</span> 2*10<sup>5</sup></span></p></div><br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Arrays</code>&nbsp;<code>Stack</code>&nbsp;<code>implementation</code>&nbsp;<code>Data Structures</code>&nbsp;