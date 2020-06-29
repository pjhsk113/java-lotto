package study4.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import study4.domain.Lotto;
import study4.domain.Lottos;
import study4.domain.Ranking;
import study4.domain.Ranking.Rank;
import study4.view.InputView;
import study4.view.ResultView;

public class LottoController {
	public static void main(String[] args) {
		
		Lottos lottonumbers = new Lottos();
		ResultView resultview = new ResultView();
		Ranking rank = new Ranking();
		
		int price = InputView.enterPriceMessage();
		
		int mannualLottoPrice = InputView.manualLottoNumber();
				
		// 수동
		List<Lotto> inputNumberByManual = lottonumbers.getLottoNumbersByManual(InputView.inputNumberByManual(mannualLottoPrice));
		// 수동을 제외한 로또		
		List<Lotto> lottos = lottonumbers.getLottoNumbers(InputView.inputNumberMessages(price - mannualLottoPrice));
		
		resultview.AutoNumberAndMannualNumberCount(price, mannualLottoPrice);
		resultview.getOutputLottoNumbers(lottos); // 리스트 출력
		
		// 지난 주 당첨 번호 입력
		List<Integer> winNumber = Lottos.winNumSplit(InputView.rankMessages());
		
		int bonusBall = InputView.enterBonusBallMessage();
				
		Map<Rank, Integer> matchNumber = rank.matchNumber(lottos, winNumber, bonusBall);
				
		resultview.outPutMessages(matchNumber, lottos);		
	}
}
