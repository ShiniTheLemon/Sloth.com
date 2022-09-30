

<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="index.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="index1.css">
  </head>
  <body>



    <div class="topnav" id="myTopnav">
          <a href="#" class="active"><img src="images/logo.jpg" alt=""></a>
          <a href="#home" class="active">Home</a>
          <a href="CreateDeck.jsp">Create Card</a>
          <a href="ShowDeck.jsp">View Deck</a>
          <a href="Quiz.jsp">Quiz</a>
          <a href="javascript:void(0);" class="icon" onclick="myFunction()">
            <i class="fa fa-bars"></i>
          </a>
    </div>

		<% 
				String user_name=null;
	if(request.getSession().getAttribute("user_name")==null){
		response.sendRedirect("login.html");
	}else
	{
		user_name=request.getSession().getAttribute("user_name").toString();
	}
		%>
			<h2>Logged in as:</h2>
	<%=user_name %>
	
        <form action="LogOutServlet" method="post"><button type="submit">Log Out</button></form>

      <table class="nav">
        <tr>  <th><h2>Remember Anything</h2></th>
              <th><h2> Remember Anywhere</h2></th>
              <th><h2> Remember Efficiently</h2></th>
        </tr>
        <tr>
          <td>From images to scientific markup, Sloth-Helper has got you covered.</td>
          <td>Review on Windows, Mac, Linux, iOS, Android, and any device with a web browser.</td>
          <td>Only practice the material that you're about to forget.</td>
        </tr>

      </table>


      <div class="row-fluid">
        <!-- main column -->
        <div class="span8">
          <h2> About Sloth-Helper</h2>

          <p>
            Sloth-Helper is a program which makes remembering things easy. Because it's a lot
            more efficient than traditional study methods, you can either greatly
            decrease your time spent studying, or greatly increase the amount you
            learn.
          </p>

          <p>
            Anyone who needs to remember things in their daily life can benefit from
            Sloth-Helper. Since it is content-agnostic and supports images, audio, videos and
            scientific markup (via LaTeX), the possibilities are endless.<br />
            For example:
          </p>
          <ul>
            <li>Learning a language</li>
            <li>Studying for medical and law exams</li>
            <li>Memorizing people's names and faces</li>
            <li>Brushing up on geography</li>
            <li>Mastering long poems</li>
            <li>Even practicing guitar chords!</li>
          </ul>
          <h2>Features</h2>

          <div class="row-fluid">
            <div class="span6">
              <p>
                <span class="lead text-heading">Synchronization</span><br />Use the
                free Sloth-HelperWeb synchronization service to keep your cards in sync across
                multiple devices.
              </p>

              <p>
                <span class="lead text-heading">Flexibility</span><br />From card
                layout to review timing, Sloth-Helper has a wealth of options for you to
                customize.
              </p>

              <p>
                <span class="lead text-heading">Media-Rich</span><br />Embed audio
                clips, images, videos and scientific markup on your cards, with
                precise control over how it's shown.
              </p>
            </div>
            <div class="span6">
              <p>
                <span class="lead text-heading">Optimized</span><br />
                Sloth-Helper will handle decks of 100,000+ cards with no problems.
              </p>

              <p>
                <span class="lead text-heading">Fully Extensible</span><br />
                There are a large number of add-ons available.
              </p>

              <p>
                <span class="lead text-heading">Open Source</span><br />Because the
                code and storage format is open, your important data is safe.
              </p>
            </div>
          </div>
        </div>
        <!-- sidebar -->
        <div class="span4 quotebar">
          <blockquote>
            <p>
              "The single biggest change that Sloth-Helper brings about is that it means
              memory is no longer a haphazard event, to be left to chance. Rather, it
              guarantees I will remember something, with minimal effort. That is,
              <i>Sloth-Helper makes memory a choice</i>."
            </p>
            <small
              ><a href="http://augmentingcognition.com/ltm.html" target="_blank"
                >Michael A. Nielsen, "Augmenting Long-term Memory"</a
              >
            </small>
          </blockquote>

          <blockquote>
            <p>
              "No other application [...] comes remotely close to Sloth-Helper in terms of the
              number and power of features, flexibility in study, or implementation of
              spaced repetition."
            </p>
            <small
              ><a
                href="http://foolsworkshop.com/reviews/index.html%3Fp=124.html"
                target="_blank"
                >K. M. Lawson, "Sloth-Helper All the Way"</a
              >
            </small>
          </blockquote>
          <blockquote>
            <p>
              "I've been using Sloth-Helper for two years now, and I just wanted to thank you
              personally for contributing to the single most obvious improvement in my
              quality of life. I'm not being hyperbolic: consistent use of Sloth-Helper has
              opened more doors for me intellectually than I could have imagined two
              years ago. And being a poor student, I'll be forever grateful that
              you've provided this software open-source and free of charge."
            </p>
            <small>Keldin, via email</small>
          </blockquote>
        </div>
      </div>





  </body>
</html>
