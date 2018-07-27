package org.javacs.kt.formatter

import com.github.shyiko.ktlint.ruleset.standard.*
import com.github.shyiko.ktlint.core.RuleSetProvider
import com.github.shyiko.ktlint.core.RuleSet
import org.javacs.kt.util.attempt

object KLSRuleSetProvider: RuleSetProvider {
	private val rules = listOf(
		attempt { ChainWrappingRule() },
		attempt { CommentSpacingRule() },
		attempt { FilenameRule() },
		attempt { FinalNewlineRule() },
		attempt { PackageNameRule() },
		attempt { IndentationRule() },
		attempt { MaxLineLengthRule() },
		attempt { ModifierOrderRule() },
		attempt { NoBlankLineBeforeRbraceRule() },
		attempt { NoConsecutiveBlankLinesRule() },
		attempt { NoEmptyClassBodyRule() },
		attempt { NoLineBreakAfterElseRule() },
		attempt { NoLineBreakBeforeAssignmentRule() },
		attempt { NoMultipleSpacesRule() },
		attempt { NoSemicolonsRule() },
		attempt { NoTrailingSpacesRule() },
		attempt { NoUnitReturnRule() },
		attempt { NoUnusedImportsRule() },
		attempt { NoWildcardImportsRule() },
		attempt { ParameterListWrappingRule() },
		attempt { SpacingAroundColonRule() },
		attempt { SpacingAroundCommaRule() },
		attempt { SpacingAroundCurlyRule() },
		attempt { SpacingAroundKeywordRule() },
		attempt { SpacingAroundOperatorsRule() },
		attempt { SpacingAroundParensRule() },
		attempt { SpacingAroundRangeOperatorRule() },
		attempt { StringTemplateRule() }
	).filterNotNull().toTypedArray()
	
	override fun get() = RuleSet("kotlin-lang-server", *rules)
}
