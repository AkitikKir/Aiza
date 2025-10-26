const express = require('express');
const cors = require('cors');

const app = express();
app.use(cors());
app.use(express.json());

app.post('/v1/chat/completions', (req, res) => {
  const { messages } = req.body;
  // simple echo reply
  res.json({
    id: "mock-1",
    choices: [
      {
        index: 0,
        message: { role: "assistant", content: "This is a mocked full response to: " + (messages?.map(m => m.content).join(" ") || "") },
        finish_reason: "stop"
      }
    ]
  });
});

// SSE streaming endpoint
app.get('/v1/chat/stream', (req, res) => {
  res.set({
    'Cache-Control': 'no-cache',
    'Content-Type': 'text/event-stream',
    Connection: 'keep-alive'
  });

  let count = 0;
  const parts = ["Hello", ", this", " is", " a", " streaming", " mock", "."];
  const interval = setInterval(() => {
    if (count < parts.length) {
      const data = JSON.stringify({ delta: parts[count] });
      res.write(`data: ${data}\n\n`);
      count++;
    } else {
      res.write(`data: [DONE]\n\n`);
      clearInterval(interval);
      res.end();
    }
  }, 100);

  req.on('close', () => {
    clearInterval(interval);
  });
});

const PORT = process.env.PORT || 8080;
app.listen(PORT, () => console.log(`Mock server listening on ${PORT}`));

