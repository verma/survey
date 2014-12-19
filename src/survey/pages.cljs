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
       [:p "This is a survey I am conducting for a fun project I want to build, so that it can help people like you.  If you want to learn more about this idea, please check this:"]
       [:a {:href "https://hackpad.com/MuchNice-JfJtwInPEnk" :target "_blank"} "MuchNice Document"]
       [:p "You don't have to read that document to enjoy this survey."]])   
    :single-choice
    ["YES! I can't wait!"]]


   ["Caffè Americano"
    (fn []
      [:div [:p {:style {:font-style :italic}} "There is a popular, but unconfirmed, belief that the name, Americano, has its origins in World War II when American G.I.s in Italy would dilute espresso with hot water to approximate the coffee to which they were accustomed."]
       [:p {:style {:text-align :right}} "- Wikipedia"]])

    :multi-choice []]

   ;; Page 4
   ["Lets Begin!"
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
    :single-choice
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


   ["If earth would stop rotating right now"
    "You would hurl out of your window at 800mph due east!"
    :multi-choice []]


   ["Did you know that all survey tools suck?"
    (fn []
      [:div
       [:p "That's why I wrote my own!"]
       [:a {:href "https://github.com/verma/survey"
            :target "_blank"} "github.com/verma/survey"]
       [:p "It's sucky but its written in Clojure so I win."]])
    :single-choice ["Yes, indeed."]]

   ["You just doubled your awesomeness! "
    "In appreciation of you taking time to complete this survey, I would like to buy you a beer.  Please give me a BTC address and I will send 0.025 BTC your way (limited supply of course)!"
    :input-field "A BTC Address"]

   ;; Last page
   ["Thanks for being so awesome!"
    "This world needs more people like you!  Thanks for completing this survey and you are very welcome for the entertainment provided.  Of course you'll be judged on the options you chose."])) 
