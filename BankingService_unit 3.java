package Unit3.Experiment3.2;

@Service
@Transactional
public class BankingService {
    @Autowired
    private AccountRepository accountRepository;

    public void transferMoney(int fromAccountId, int toAccountId, double amount) {
        Account fromAccount = accountRepository.findById(fromAccountId).get();
        Account toAccount = accountRepository.findById(toAccountId).get();
        
        if (fromAccount.getBalance() >= amount) {
            fromAccount.setBalance(fromAccount.getBalance() - amount);
            toAccount.setBalance(toAccount.getBalance() + amount);
            accountRepository.save(fromAccount);
            accountRepository.save(toAccount);
        } else {
            throw new InsufficientFundsException("Not enough balance");
        }
    }
}
