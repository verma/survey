(ns survey.pages)

(defn make-survey [& pages]
  (mapv (fn [[title content type options]]
          (merge {:key (str (gensym))
                  :title title
                  :content content}
                 (when (and type options)
                   {type options}))) pages))

(def all-pages
  (make-survey

   ;; Page 1
   ["I HATE SURVEYS!"
    "MOTHERFRACKIN' SURVEY"
    :single-choice
    ["FUCK YEAH ANOTHER SURVEY!" "FUCK NO! GTFO"]]

   ;; Page 2
   ["Great Choice!"
    "I promise I will try to keep you entertained by showing you tons of cool stuff and by making ample use of my \"trying too hard\" cheesy cheap humor!"
    :single-choice
    ["Very well."]]

   ;; Page 3
   ["Hear me out!"
    (fn []
      [:div
       [:p "This is a survey I am conducting for a fun project I want to build, so that it can help people like you.  People who are in need of top class talent.  Talent which is rare and hard to find!  I want to create a marketplace for them!"]
       [:p {:style {:font-style :italic}} "\"Screw your idea man! shit! another one of those bullshit body-shopping websites where cheap shit is made and sold and everyone is trying to undercut each other? Fuck that shit I am out of here, btw thanks for wasting my time!!
\""]
       [:p "Now hold on one second.  I know what you are talking about and I am sure that I share your opinion, may be not as fervently!  Those sites are not very nice and please calm down, lets keep this civil."]])   
    :single-choice
    ["Sure, I am sorry I lost it there a little bit..."]]

   ;; Page 4
   ["Your rage is completely understandable"
    "When looking for a new hire how would you say you feel?"
    :multi-choice
    ["Actually not bad at all!"
     "Like punching something"
     "Anxious"
     "Adventurous"
     "Frustrated"
     "Hate the fact that you were born a human being and not a cat"]] 

   ;; Page 5
   ["Alright! Fun stuff coming up!"
    "What would you say some of your concerns are when hiring a new employee?"
    :multi-choice
    ["Finding someone good"
     "Distinguishing awesome talent from mediocre ones"
     "Employment Fudge: Insurance, Benefits and all that shit"
     "Long term commitments"
     "Training someone new and bringing them up to speed"
     "Finding a problem solver over a Coder"]]

   ;; Page 6
   ["Ok, here you go!"
    (fn []
      [:div
       [:p "courtesy /r/funny"]
       [:img {:src "http://i.imgur.com/T5clkm6.jpg"}]])
    :multi-choice []]

   ;; Page 7
   ["How do you feel about this sentiment?"
    (fn []
      [:p {:style {:font-style :italic}}
       "\"I'd rather hire someone who knows their shit than someone I'd have to work with a lot!\""])
    :single-choice
    ["I agree"
     "Neutral"
     "I disagree"
     "I don't really know"]]

   ;; Page 8
   ["Ok, how about this?"
    (fn []
      [:p {:style {:font-style :italic}}
       "\"I'd rather hire someone expensive who knows their shit than someone cheap I'd have to work with a lot!\""])
    :single-choice
    ["I agree"
     "Neutral"
     "I disagree"
     "I don't really know"]]

   ["Do you know what SIMD is?"
    "Its a CPU instruction set extension which stands for Single Instruction Multiple Data.  A way to operate on different data simultaneously.  E.g. if you want to add two 3D vectors, you can add all components of two vectors simultaneously, instead of doing one component at a time."
    :single-choice
    ["I knew that already smartass!"
     "TIL"]]


   ["How often does this happen to you?"
    (fn []
      [:p {:style {:font-style :italic}}
       "\"Oh this person is doing amazing stuff!  Look at all the cool project (s)he has worked on! Wish I could work with h(er|im) for a few months.  It would be great for me personally, my employees and my company!\""])
    :single-choice
    ["Quite frequently"
     "More often that I'd like"
     "Occasionally"
     "Never"]]


   ["More fun stuff!"
    (fn []
      [:div
       [:p "In 2012, a guy punched a $8,000,000 painting at a museum in Ireland.  Got 6 years."]
       [:p "source: /r/pics"]
       [:img {:src "http://i.imgur.com/OK8SlrH.jpg"}]])
    :multi-choice []]


   ["Just a few more, I promise!"
    "How often do you need badass programmers?"
    :multi-choice
    ["As often as I can find them"
     "Just to build MVP stuff quickly"
     "Just during few phases of our project's life-cycle"
     "Almost never, I am a badass programmer!"]]

   ["Last one!"
    "Which sentiment do you most agree with?"
    :multi-choice
    ["I want to hire people who will grow with the company"
     "I want to hire problem solvers who will help me achieve my goals"
     "I want mercenary programmers who will do mind bending stuff for me"
     "I want the best talent for my business without all the hassle of going and finding one"
     "I care more about the chemistry of my team over what it actually achieves"
     "I know that all good things cost money"
     "I am not a cheap person"]]


   ["If earth would stop rotating right now!"
    "You would hurl out of your window at 800mph due east"
    :multi-choice []]


   ["Did you know that all survey tools suck?"
    (fn []
      [:div
       [:p "That's why I wrote my own!"]
       [:a {:href "https://github.com/verma/survey"
            :_target "blank"} "github.com/verma/survey"]
       [:p "It's sucky but its written in Clojure so I win."]])
    :single-choice ["Yes you did, indeed."]]

   ;; Last page
   ["You are awesome!"
    "Thanks for completing this survey and you are very welcome for the entertainment provided.  Of course you'll be judged on the options you chose."])) 
