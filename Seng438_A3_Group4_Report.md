**SENG 438 - Software Testing, Reliability, and Quality**


**Lab. Report \#3 – Code Coverage, Adequacy Criteria and Test Case Correlation**


| Group \#:         |  4  |
| ----------------- | --- |
| Student Names:    |     |
| Alexander Sembrat |     |
| Andrew Howe       |     |
| Hajin Kim         |     |
| Jenna Vlaar       |     |




# 1 Introduction


The purpose of this lab was to further learn about JUnit testing as well as introduce the topic of white-box testing and determining our own test cases to develop. We are expected to work as a team to expand our knowledge of testing as well as qualitatively measure our test suite’s adequacy. This will be completed through utilizing code coverage tools, designing test cases, understanding the consequences of measuring with these code coverage tools and understanding data-flow coverage.


# 2 Manual data-flow coverage calculations for X and Y methods


DataUtilities.calculateColumnTotal and Range.getCentralValue




# 3 A detailed description of the new testing strategy for the new unit test


The first step in our new test plan is to discover the coverage of our current test suite. Once this is identified we will analyze the results to see where we are missing coverage then add tests to improve the coverage. As we add tests we will re-run EclEmma to find the new coverage.


Due to elcemma not having statement or condition coverage they will be substituted with Method and Line coverage respectively.


The coverage of our current test suite is:
Range: 11.0% Branch, 13.4% Line, 26.1% Method
DataUtilities: 17.2% Branch, 27.1% Line, 30.0% Method


After analyzing the initial coverage our plan is as follows:


-Write tests for previously untested methods to increase method coverage.

-Analyze the branch coverage and write new tests that follow all possible branches.

-Re analyze the test suite after writing each new test to see if it has improved coverage as expected.

-Repeat until minimal acceptable coverage is obtained.


# 4 A high level description of five selected test cases you have designed using coverage information and how they have increased code coverage


Several of the test cases we wrote were new to our test suite, thus automatically increasing our code coverage. These tests increased the code coverage by following previously untested branches of the methods. We achieved method coverage by adding tests for methods that were previously untested. Line coverage was increased by increasing both branch and method coverage as more lines of the code were covered as more methods and branches were tested.


A couple Examples from Data Utilities:


calculateColumnTotalPosArray()

-Increased Branch Coverage by 7.8%, Line Coverage by 1.9% and Method Coverage by 10.0%

calculateRowTotalPosArray()

-Increased Branch Coverage by 7.8%, Line Coverage by 1.9% and Method Coverage by 10.0%


A few examples from Range:


testExpandNormal()
-Increased Branch Coverage by 1.2%, Line Coverage by 6.7% and Method Coverage by 4.3%
testCombineNoNull()
-Increased Branch Coverage by 1.2%, Line Coverage by 2.5% and Method Coverage by 0%
testConstrainLowerBound()
-Increased Branch Coverage by 2.4%, Line Coverage by 1.7% and Method Coverage by 4.3%


Here is a list of all tests added and a summary of the new coverage:


Data Utilities:
clone(double[][] source)
-cloneArray()
-cloneArrayWithNull()
-testEqualsDiffLenghts()
equal(double[][] a, double[][] b)
-testEqualsDiffLenghts()
-testEqualsNull1()
-testEqualsNull2()
-testEqualsCorrect()
-testEqualsWrong()
-testEqualsNulls()
calculateColumnTotal(Values2D data, int column)
-calculateColTotalWithNull()
calculateRowTotal(Values2D data, int row)
-calculateRowTotalWithNull()
calculateColumnTotal(Values2D data, int column,int[] validColumns)
-calculateColumnTotalPosArray()
calculateRowTotal(Values2D data, int Row,int[] validRows)
-calculateRowTotalPosArray()
New Coverage: 73.4% Range, 87.5% Line (condition substitute), 90.0% Method (statement substitute)


Range:
contains(double value)
-testContainsLarger()
intersects(double b0, double b1)
-testIntersecstsTrue()
-testIntersecstsTrue1()
-testIntersectsFalse()
intersects(Range range)
-testIntersectsRange()
constrain(double value)
-testConstrainUpperBound()
-testConstrainLowerBound()
-testConstrainWithinBound()
combine(Range range1, Range range2)
-testCombineNoNull()
-testCombine1Null()
-testCombine2Null()
combineIgnoringNaN(Range range1, Range range2)
-testCombineNan1Null2Nan()
-testCombineNan1Null2Valid()
-testCombineNan2Null1Nan()
-testCombineNan2Null1Valid()
-testCombineNan1Null2Null()
-testCombineNanValid()
-testCombineNanBothNaN()
-testCombineNan1Valid2NaN()
-testCombineNan1NaN2Valid()
expandToInclude(Range range, double value)
-testExpandToIncludeIncludeNull()
-testExpandToIncludeBelowRange()
-testExpandToIncludeAboveRange()
-testExpandToIncludeInRange()
expand(Range range, double lowerMargin, double upperMargin)
-testExpandNormal()
-testExpandNegative()
New Coverage:84.1% Range, 87.4% Line, 100.0% Method




# 5 A detailed report of the coverage achieved of each class and method (a screen shot from the code cover in green and red color would suffice)






# 6 Pros and Cons of coverage tools used and Metrics you report
	
For this lab, we used EclEmma to report the coverage metrics of our test suite. This analysis tool allowed us to report the instruction, branch, line, method, type and complexity coverages. However, this tool did not provide information on the statement or condition metrics. EclEmma is a very easy-to-use and automatic tool when analyzing the test suite. It did not require any manual computation to acquire any of the metrics. Although it provided some metric analysis, EclEmma was limited in a few of the common coverage metrics used in test analysis. The metrics we chose to report were method, branch and line coverage. Line coverage examines how many lines of the source code were tested, branch coverage examines how many branches of the control structure were executed and method coverage examines whether a method was entered during test execution.


# 7 A comparison on the advantages and disadvantages of requirements-based test generation and coverage-based test generation.


Requirements-based test generation is advantageous in that it is very simple to generate test cases when you are given requirements for the code. However, this form of test generation often misses certain parts of the test’s code, therefore it can cause uncertainty in whether the test is fully issue-free. Coverage-based test generation is advantageous in that it can be easily automated by tools such as EclEmma. It produces a quantifiable result that can help guide the improvement of the test suite. However this test generation method is flawed in that it does not take into account the requirements of the system, simply whether or not the code functions correctly. This sort of functionality cannot be automatically implemented, therefore you cannot ensure that a program will function correctly if you simply implement coverage-based test generation.




# 8 A discussion on how the team work/effort was divided and managed


For the beginning part of the lab, all three group members installed EclEmma and attempted to compute the three different coverage methods for our test suite. We decided to collaborate on the manual computation of the data flow coverage to produce our diagrams and computations. We divided the final section of the lab by workload, similar to assignment two. Each of the methods we wrote in assignment 2 were reassigned to improve code coverage individually. After we completed our new test cases, we reviewed each other’s work and ensured all of the methods met the minimum coverage requirements.




# 9 Any difficulties encountered, challenges overcome, lessons learned from performing the lab


There was some difficulty in attaining full branch coverage for several of the test cases. This is because several of the statements in the method were unreachable due to previous conditions. We managed to still meet the percentages by writing more test cases for other methods to account for the lost branch coverages. We successfully learned how to utilize the coverage metric tools to guide our coverage driven test development as well as how to determine these metrics by hand. We gained a firm understanding of white-box testing and the differences between requirements driven test design and coverage-based test design.


# 10 Comments/feedback on the lab itself


This lab contained significantly more tasks to complete while not allocating extra time to account for the effort. There were more test cases to write than the previous lab on top of learning how to use analysis tools by ourselves, calculating test coverages for these test cases and writing graphs, calculations and coverages by hand. There was not much guidance on how to complete any of these tasks so it took a lot of time to teach ourselves the content to complete the lab. Once we figured out exactly what we had to do it went fairly quickly. Another annoyance was that the EclEmma program which was recommended did not have the types of coverage asked of us so we had to make the decision to substitute a couple types of the coverage.
