# AMA (Ask Me Anything) Tool 

## Team Members: Gang Of Four 
* Akhila Ananth
* Jonathan Scothorn
* Joel Prakash
* Adhiraj Chakraborty

## Running Instructions:
To:
 * Create a new User: http:localhost:8080/user-creation
 * The are navigation buttons to all other pages from this page 
 * There is a Heroku link under the 'Current' heading below 

## Current
[Heroku](https://amatool.herokuapp.com/user-creation)
![ui_sketch](https://cloud.githubusercontent.com/assets/6691781/24067620/88b5f078-0b55-11e7-8111-c3ff2f20d863.jpg)

## REST API: 
* /home GET: homepage
* /user-creation GET: account creation form
* /user-creation POST: submit account creation form
* /users GET: show existing users
* /users/{userhandle} GET: show a user profile corresponding to the userhandle
* /users/{userhandle}/ama-creation GET: ama creation form
* /users/{userhandle}/ama-creation POST: submit AMA creation form
* /users/{userhandle}/amas GET: show AMAs of the user corresponding to userhandle
* /users/{userhandle}/amas/{amaid} GET: show a AMA corresponding to the amaid (including question submission)
* /users/{userhandle}/amas/{amaid} POST: submit a question to the AMA corresponding to amaid
* /users/{userhandle}/amas/{amaid}/questions GET: view all questions associated with the AMA corresponding to amaid


## Initial Product Backlog:

### General Backlog: 
Add Functionality to:
* Update answers
* change AMA parameters
* Follow users
* Restrict AMA visibility to specified users
* Implement deadline functionality: deadline to vote on questions
* like AMAs
* Restrict post after dealine for questions
* Create questions 
* Vote on questions

### View Backlog: 
Develop Views for:
* Questions linked from AMAs
* User profile
* View full AMA (not basic)

### Search Backlog: 
Have the ability to:
* Search followers (Context : User)
* Search for users (Context : Home page)
* Search questions (Context : AMA)
* Search for AMA (Context : User/Home page)

## Short Description of the Product:

Ask Me Anything tool: A user can create an AMA by entering a bit of preamble text and set a few parameters (such as the topic tags/keywords, the deadline, is it “open” to the public or “restricted” to a given supplied list). Users can ask a question or vote “up” or “down” existing questions. The questions can be listed in increasing or decreasing order of votes, and they dynamically move up or down as the votes are in. A user can vote on many questions in an AMA, but cannot vote more than once on any given question (that’s ballot stuffing!). In our design, the user has the choice to upvote or downvote on a question. When the deadline is reached, no more votes are allowed, and the user who created the AMA can now answer them by another deadline that is known to the participants. All AMAs (active and archived) that are public are searchable by keywords/tags, posted date, deadline, creator’s name/handle. User can “like” a given AMA and “follow” users, and so they can also search for most “liked” AMAs, or AMAs posted by the most “followed” users, or restrict their search to only those users they follow. One can also lookup a user profile and see which AMAs they’ve created or liked, and which other users they follow.

## Plan for the next sprint:
By the next Sprint, we hope to be able to:
* Vote on Questions
* Update answers for questions 
* Create a welcome page: Implement login functionality 
* Bootstrap the Web app
* Testing 
* Coverage of unit tests
* Fix current bugs

