const player1 = 'X';
const player2 = 'O';
let currentPlayer = player1;
let gameEnded = false;

const board = [
	['', '', ''],
	['', '', ''],
	['', '', '']
];

const cells = document.querySelectorAll('.cell');
cells.forEach(cell => {
	cell.addEventListener('click', () => {
		if (cell.textContent || gameEnded) {
			return;
		}

		const [row, col] = cell.id.split('-');
		board[row][col] = currentPlayer;
		cell.textContent = currentPlayer;
		cell.classList.add(currentPlayer === player1 ? 'x' : 'o');

		if (checkWin()) {
			document.getElementById('status').textContent = `${currentPlayer} won!`;
			gameEnded = true;
			return;
		}

		if (checkDraw()) {
			document.getElementById('status').textContent = 'Draw!';
			gameEnded = true;
			return;
		}

		currentPlayer = currentPlayer === player1 ? player2 : player1;
		document.getElementById('status').textContent = `Current player: ${currentPlayer}`;
	});
});

document.getElementById('reset').addEventListener('click', resetGame);

function checkWin() {
	for (let i = 0; i < 3; i++) {
		if (board[i][0] === currentPlayer && board[i][1] === currentPlayer && board[i][2] === currentPlayer) {
			return true;
		}
		if (board[1][i] === currentPlayer && board[2][i] === currentPlayer && board[0][i] === currentPlayer) {
			return true;
		}
	}
	if (board[0][0] === currentPlayer && board[1][1] === currentPlayer && board[2][2] === currentPlayer) {
		return true;
	}
	if (board[2][0] === currentPlayer && board[1][1] === currentPlayer && board[0][2] === currentPlayer) {
		return true;
	}
	return false;
}

function checkDraw() {
	for (let i = 0; i < 3; i++) {
		for (let j = 0; j < 3; j++) {
			if (board[i][j] === '') {
				return false;
			}
		}
	}
	return true;
}

function resetGame() {
	board.forEach(row => row.fill(''));
	cells.forEach(cell => {
		cell.textContent = '';
		cell.classList.remove('x');
		cell.classList.remove('o');
	});
	currentPlayer = player1;
	gameEnded = false;
	document.getElementById('status').textContent = `Current player: ${currentPlayer}`;
}

document.getElementById('restart').addEventListener('click', resetGame);

document.getElementById('player1').addEventListener('input', function() {
	player1 = this.value;
	document.getElementById('player1Label').textContent = `Player 1 (${player1}):`;
	resetGame();
});

document.getElementById('player2').addEventListener('input', function() {
	player2 = this.value;
	document.getElementById('player2Label').textContent = `Player 2 (${player2}):`;
	resetGame();
});