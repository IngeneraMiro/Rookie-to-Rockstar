# Rookie-to-Rockstar
assignment problem from Mentormate  

The problem is good one. I am not great builder but....
My logic is - we have to start building from bottom to top and from left to the right.

Number of bricks is multilied dimension of matrix devided by 2.
They are numbered from 1 to the number of bricks.
As it is allowed a brick with given number to half step on top of a brick with the same number from first layer - conclusion is that
 numberung of the brick is not important - main target is to bould second layer in such way that a brick from the second to step on top 
 of two briks from the first layer. Showed nimering is only to separate visually the bricks and doesn't matter at all !!!!  

As we have the first layer already built then we have to start building second layer following next rules:
   - build from bottom to top
   - from lefr to the right
   - check first on first layer if there is enough room and if we can place the brick horizontaly (to not place it fully on top of other brick)
   - if not then check if there is enough room and if we can place it vertically (to not place it fully on top of other brick)
   - on every bick the starting poin is first free left cell fom bottom to top
   - on every even row we are going only to the right
